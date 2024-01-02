package jeanoza.backendspring;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class CookieUtils {

    public static ResponseCookie createCookie(String name, String value, int maxAge) {
        return ResponseCookie.from(name, value)
                .maxAge(maxAge)
                .path("/")
                .build();
    }

    public static HttpHeaders addCookieToHeaders(ResponseCookie cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString());
        return headers;
    }

    public static HttpHeaders createHeaderWithCookie(String name, String value, int maxAge) {
        ResponseCookie cookie = CookieUtils.createCookie(name, value, maxAge);
        return addCookieToHeaders(cookie);
    }

    public static Long getUserIdByCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new RuntimeException("No auth");
        }
        Optional<String> memberId = Arrays.stream(cookies)
                .filter(cookie -> "user_id".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();

        if (memberId.isPresent()) {
            return Long.parseLong(memberId.get());
        }
        throw new RuntimeException("Not auth info");
    }
}