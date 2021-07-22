package com.signette.signature;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.*;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Properties;

public class SignatureExternalHash {
 
    /**
     * A properties file that is PRIVATE.
     * You should make your own properties file and adapt this line.
     */
    public static String PATH = "key.properties";
    /** Some properties used when signing. */
    public static Properties properties = new Properties();
 
    /** The resulting PDF */
    //public static String SIGNED1 = "signedRecu.pdf";
	//private static String input = "recu.pdf";

    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param dest the resulting PDF
     * @throws GeneralSecurityException 
     * @throws IOException 
     * @throws DocumentException 
     * @throws FileNotFoundException 
     * @throws KeyStoreException 
     * @throws Exception 
     */
    public void signPdfDetached(String src, String dest) throws GeneralSecurityException, IOException, DocumentException {
    	// Private key and certificate
        String path = "zz.p12";
        KeyStore ks = KeyStore.getInstance("pkcs12", "BC");
        String keystore_password="nad";
		ks.load(new FileInputStream(path), keystore_password.toCharArray());
        String alias = (String)ks.aliases().nextElement();
        PrivateKey pk = (PrivateKey) ks.getKey(alias, keystore_password.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);
 
        // reader and stamper
        PdfReader reader = new PdfReader(src);
        FileOutputStream os = new FileOutputStream(dest);
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');
 
        // appearance
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason("Virement effectue ");
        appearance.setLocation(""+new Date());
        appearance.setVisibleSignature(new Rectangle(72, 732, 144, 780), 1, "sig");
 
        // digital signature
        ExternalSignature es = new PrivateKeySignature(pk, "SHA-256", "BC");
        ExternalDigest digest = new BouncyCastleDigest();
        MakeSignature.signDetached(appearance, digest, es, chain, null, null, null, 0, CryptoStandard.CMS);
    }
 
   
    public static void sign(String input,String SIGNED1)
        throws IOException, DocumentException, GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        properties.load(new FileInputStream(PATH));
      
        SignatureExternalHash signatures = new SignatureExternalHash();
        signatures.signPdfDetached(input, SIGNED1);
    }
}