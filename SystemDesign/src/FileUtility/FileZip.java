package FileUtility;

public class FileZip extends FileWrapper {

    private IZip zip;

    public FileZip(IFile file, IZip zip) {
        this.file = file;
        this.zip = zip;
    }

    @Override
    public void create() {
        zip.create();
        super.create();
    }
}
