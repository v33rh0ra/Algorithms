package com.v33rh0ra.algorithms.codingconstructs.newio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class WatchServiceExplorer {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cwd = Paths.get(".").toRealPath().toString();
        Path path = Paths.get("/usr/local");
        WatchService ws = FileSystems.getDefault().newWatchService();
        WatchKey wk = path.register(ws, ENTRY_CREATE);

        while(true){
            WatchKey key = ws.take();
            List<WatchEvent<?>> pollEvents = key.pollEvents();
            try{
                for(WatchEvent<?> event: pollEvents){
                    Path p = (Path) event.context();
                    System.out.println(p.toRealPath().toString());
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                key.reset();
            }
        }
    }
}
