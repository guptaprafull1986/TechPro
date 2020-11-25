package FileUtility;

public class FileEncoding extends FileWrapper {
    private IEncoding encoding;

    public FileEncoding(IFile file, IEncoding encoding) {
        this.file = file;
        this.encoding = encoding;
    }

    @Override
    public void create() {
        encoding.create();
        super.create();
    }
}
