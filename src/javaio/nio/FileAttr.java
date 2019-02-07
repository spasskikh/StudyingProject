package javaio.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.nio.file.attribute.AclEntryPermission.*;

public class FileAttr {

    public static void main(String[] args) throws IOException {
        Path temp = Paths.get("temp");
        System.out.println("Size: " + Files.size(temp));
        System.out.println("Last modified time: " + Files.getLastModifiedTime(temp));
        System.out.println("Is writable: " + Files.isWritable(temp));

//        attrView(temp);

        userPrincipal(temp);
    }

    private static void attrView(Path path) throws IOException {

        FileStore fs = Files.getFileStore(path);

        validateView(fs, BasicFileAttributeView.class);
        validateView(fs, DosFileAttributeView.class);
        validateView(fs, PosixFileAttributeView.class);
        validateView(fs, AclFileAttributeView.class);
        validateView(fs, UserDefinedFileAttributeView.class);
        validateView(fs, FileOwnerAttributeView.class);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.creationTime());

    }

    private static void validateView(FileStore fs, Class<? extends FileAttributeView> viewClass) {
        boolean supports = fs.supportsFileAttributeView(viewClass);
        System.out.println("Supports: " + viewClass.getSimpleName() + " - " + supports);
    }

    private static void userPrincipal(Path path) throws IOException {
        UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("anton");
        AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
        AclEntry aclEntry = AclEntry.newBuilder()
                .setType(AclEntryType.ALLOW)
                .setPrincipal(user)
                .setPermissions(DELETE, READ_ATTRIBUTES, READ_DATA)
                .build();
        List<AclEntry> ac1 = view.getAcl();
        ac1.add(aclEntry);
        view.setAcl(ac1);

    }
}
