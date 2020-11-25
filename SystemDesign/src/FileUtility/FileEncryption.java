package FileUtility;

public class FileEncryption extends FileWrapper {
    IEncryption encryption;

    public FileEncryption(IFile file, IEncryption encryption) {
        this.file = file;
        this.encryption = encryption;
    }

    @Override
    public void create() {
        encryption.create();
        super.create();
    }
}
