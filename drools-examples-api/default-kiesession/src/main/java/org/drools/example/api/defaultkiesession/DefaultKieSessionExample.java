package org.drools.example.api.defaultkiesession;

import org.kie.KieServices;
import org.kie.runtime.KieContainer;
import org.kie.runtime.KieSession;

import java.io.PrintStream;

public class DefaultKieSessionExample {
    
    public void go(PrintStream out) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        
        KieSession kSession = kContainer.newKieSession( );
        kSession.setGlobal( "out", out );
        kSession.insert( new Message("Dave", "Hello, HAL. Do you read me, HAL?") );
        kSession.fireAllRules();
    }    
    
    
    public static void main( String[] args ) {
        new DefaultKieSessionExample().go( System.out );
    }

}
