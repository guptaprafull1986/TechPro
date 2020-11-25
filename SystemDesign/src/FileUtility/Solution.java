package FileUtility;

public class Solution {
    public static void main(String[] args) {
        IFile tf = new TextFile();

        IFile file = new FileEncoding(new FileEncryption(tf, new DESEncryption()), new ASCIIEncoding());
        file.create();
    }
}
