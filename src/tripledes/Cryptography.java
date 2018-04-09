/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripledes;

/**
 *
 * @author Deelaka Algawatta
 */
public abstract class Cryptography{

    String key="mnbvcxzasdfghjkloiuytrew";
    public abstract long Encrypt(String filepath);
    public abstract long Decrypt(String filepath);

    
}
