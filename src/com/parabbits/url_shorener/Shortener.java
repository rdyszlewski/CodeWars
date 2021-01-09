package com.parabbits.url_shorener;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/*
Background Information
When do we use an URL shortener?

In your PC life you have probably seen URLs like this before:

    https://bit.ly/3kiMhkU

If we want to share a URL we sometimes have the problem that it is way too long, for example this URL:

    https://www.google.com/search?q=codewars&tbm=isch&ved=2ahUKEwjGuLOJjvjsAhXNkKQKHdYdDhUQ2-cCegQIABAA&oq=codewars&gs_lcp=CgNpbWcQAzICCAAyBAgAEB4yBAgAEB4yBAgAEB4yBAgAEB4yBAgAEB4yBAgAEB4yBAgAEB4yBAgAEB4yBggAEAUQHlDADlibD2CjEGgAcAB4AIABXIgBuAGSAQEymAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=RJmqX8aGHM2hkgXWu7ioAQ&bih=1099&biw=1920#imgrc=Cq0ZYnAGP79ddM

In such cases a URL shortener is very useful.
How does it work?

The URL shortener is given a long URL, which is then converted into a shorter one. Both URLs are stored in a database. It is important that each long URL is assigned a unique short URL.

If a user then calls up the short URL, the database is checked to see which long URL belongs to this short URL and you are redirected to the original/long URL.

Important Note: Some URLs like www.google.com are used very often, it can happen that two users want to shorten the same URL, so you have to check if this URL has been shortened before to save memory in your database.
Task
URL Shortener

Write a function urlShortener(longUrl), which receives a long URL and returns an URL consisting only of lowercase letters (and one dot and one slash).

Every short URL has to include short.ly/ and must not be longer than 13.

Note: short.ly/ is not a valid short URL.
Redirect URL

Write a function urlRedirector(shortUrl), which receives the shortened URL and returns the corresponding long URL.
Performance

There are 475_000 random tests. You don't need a complicated algorithm to solve this kata, but iterating each time through the whole database to check if a URL was used before or generating short URLs based on randomness, won't pass.
 */
public class Shortener {

    // TODO: zrobić wersję z poprawą wydajności
    
    private final String BASE = "short.ly/";
    private final Map<String, String> shortUrlsMap = new ConcurrentHashMap<>();
    private final Map<String, String> longUrlsMap = new ConcurrentHashMap<>();


    public String urlShortener(String longURL) {
        if(longUrlsMap.containsKey(longURL)){
            return longUrlsMap.get(longURL);
        }

        String generatedString = generateCode();
        shortUrlsMap.put(generatedString, longURL);
        longUrlsMap.put(longURL, BASE  +  generatedString);
        return BASE + generatedString;
    }

    private String generateCode(){
        boolean correctFormat = false;
        Random random = new Random();
        String generatedString;
        do{
            generatedString = random.ints(97, 122 + 1)
                    .limit(4)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            if(!shortUrlsMap.containsKey(generatedString)){
                correctFormat = true;
            }
        }while(!correctFormat);

        return generatedString;
    }

    public String urlRedirector(String shortURL) {
        String code = shortURL.replace(BASE, "");
        if(shortUrlsMap.containsKey(code)){
            return shortUrlsMap.get(code);
        }
        return "";
    }
}
