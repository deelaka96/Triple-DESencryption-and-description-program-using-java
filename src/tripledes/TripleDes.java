/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripledes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Deelaka Algawatta
 */
public class TripleDes extends Cryptography{

long startTime =0;
long endTime=0;
long duration=0;

String name;
FileInputStream i;
FileOutputStream o;
int numBytes;
byte[] bytes = new byte[64];

public TripleDes(String file) throws FileNotFoundException{   
     i=new  FileInputStream(file);  
     name=FilenameUtils.getName(file);
     
}
    
    

    @Override
    public long Encrypt(String filepath) {
        
  
        try {
            
             o=new  FileOutputStream(filepath+"\\enc_"+name);
             SecretKey skey = new SecretKeySpec(key.getBytes(), "DESede");
             IvParameterSpec iv = new IvParameterSpec(new byte[8]);
             
             startTime = System.currentTimeMillis();
       	     Cipher cr=Cipher.getInstance("DESede/CBC/PKCS5Padding");
             
             cr.init(cr.ENCRYPT_MODE,skey,iv);
       
            CipherInputStream cis = new CipherInputStream(i, cr);
            while ((numBytes = cis.read(bytes)) != -1) {
            
			o.write(bytes, 0, numBytes);
		}
             endTime = System.currentTimeMillis();
	     duration = (endTime - startTime); 
                     
             i.close();
             o.close();
                        
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidAlgorithmParameterException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
         return duration;
    }

    @Override
    public long Decrypt(String filepath) {
        
    try {
        
        startTime = System.currentTimeMillis();
        o=new  FileOutputStream(filepath+"\\dec_"+name);
                     IvParameterSpec iv = new IvParameterSpec(new byte[8]);

        SecretKey skey = new SecretKeySpec(key.getBytes(), "DESede");
                startTime = System.currentTimeMillis();

        Cipher cr=Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cr.init(cr.DECRYPT_MODE,skey,iv);
        
        CipherInputStream cis = new CipherInputStream(i, cr);
        while ((numBytes = cis.read(bytes)) != -1) {
            o.write(bytes, 0, numBytes);
        }
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        
        i.close();
        o.close();
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchPaddingException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidKeyException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidAlgorithmParameterException ex) {
        Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
    }
        return duration;
            

    }

}