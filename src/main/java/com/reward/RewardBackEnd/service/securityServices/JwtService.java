package com.reward.RewardBackEnd.service.securityServices;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

//    private final String  key = "vxKL401WsCa7fktcI0rhebjkzbO48qMl8Zkxg19KxDI=";
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public boolean isValid(String token, UserDetails user) {
//        String username = extractUsername(token);
//        return username.equals((user.getUsername())) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
//        Claims claims = extractAllClaims(token);
//        return resolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts
//                .parser()
//                .verifyWith(getSigninKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    public String generateToken(User user) {
//        String token = Jwts
//                .builder()
//                .subject(user.getUsername())
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
//                .signWith(getSigninKey())
//                .compact();
//
//        return token;
//    }
//
//    private SecretKey getSigninKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(key);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }

}

