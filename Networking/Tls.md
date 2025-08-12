# TLS

![img.png](../images/img_2.png)

Alright — let’s deep-dive into SSL certificates and how they work, step-by-step, from the moment you type https:// in your browser until you see the secure lock icon.

1. Purpose of SSL/TLS
SSL (Secure Sockets Layer) — and its successor TLS — ensures:
- Encryption → Data between you and the server is unreadable to others.
- Authentication → You know you're talking to the real website (not an imposter).
- Integrity → Data isn’t altered during transit.


2. Key Concepts

- Public Key Cryptography → Uses a public key (to encrypt) and a private key (to decrypt).
- Certificate Authority (CA) → Trusted third-party that issues certificates after verifying the domain/organization.
- Digital Certificate → File containing the site's public key + identity details, signed by a CA.


### Step 1 – You Request the Site

You type https://example.com and your browser says:
- “I want a secure connection. Server, please prove your identity.”

### Step 2 – Server Sends Its Certificate

Server responds with:
1. Public key
2. Domain name
3. Organization details
4. CA signature (digital signature)
5. Expiry date

```text
{
  domain: example.com,
  publicKey: ABC123,
  issuedBy: DigiCert,
  validUntil: Jan 2026,
  signature: <CA digital signature>
}
```

### Step 3 – Browser Verifies the Certificate

1. Browser checks if the certificate:
- Is signed by a trusted CA (from browser/OS's built-in trust store).
- Is not expired or revoked.
- Matches the domain (example.com).

2. Browser verifies the CA’s digital signature using the CA’s public key (already in your system).
If verification fails → Browser shows a certificate error.


### Step 4 – Key Exchange

Once the certificate is trusted:

- Browser and server perform a handshake to agree on:
- Encryption algorithm (AES, ChaCha20, etc.)
- Session key (a temporary symmetric key for the session)
- This session key is random and is exchanged securely using the server’s public key (from the certificate) or Diffie-Hellman key exchange.


### Step 5 – Secure Communication

- All data is encrypted with the session key.
- Since symmetric encryption is fast, it’s used for the rest of the connection.
- If anyone intercepts packets, they see encrypted gibberish.



### Summary of the Handshake
1.    Browser → Server: "Let’s talk securely."
2.    Server → Browser: "Here’s my certificate + public key."
3.    Browser: "I trust this CA, verified signature, domain matches."
4.    Browser → Server: "Here’s a random session key, encrypted with your public key."
5.    Both: Switch to symmetric encryption for speed.




