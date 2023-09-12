import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Base64;
import java.util.Scanner; 

public class AEScipher {
    private static String Encrypt(byte[] key, byte[] initVector, byte[] value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value);
            String enString = Base64.getEncoder().encodeToString(encrypted);
            
            return enString;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void test(String plainText) throws Exception {
        
        byte[] Key = "QX5PNYo8NgSIn7v46JomDqbb".getBytes();
        byte[] iv = "Z62BZzhu3NkkfBrX".getBytes();
        byte[] value = plainText.getBytes("utf-8");
        String enString = AEScipher.Encrypt(Key, iv, value);
        System.out.println("密文：" + enString);
        
    }

    public static void main(String[] args){
        System.out.print("請輸入您想加密的內容:");
        Scanner myobj = new Scanner(System.in);
        String plainText = myobj.nextLine();

        try{
            test(plainText);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

     