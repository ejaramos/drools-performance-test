package com.sample;


import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.conf.RuleEngineOption;

public class RulesRunner {
 
    @SuppressWarnings("restriction")
	public static void main(String[] args) {
    	String csvFile = "/Users/ejaramos/Desktop/dev/java/drools-performance-test/src/main/java/com/sample/data.csv";
		BufferedReader br= null;
		String line = "";
		String delimiter = ",";
	
		// Start Time
		long startTime = System.currentTimeMillis();
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieBaseConfiguration kconfig = KieServices.Factory.get().newKieBaseConfiguration();
            kconfig.setOption(RuleEngineOption.PHREAK);
            //kconfig.setOption(RuleEngineOption.RETEOO);
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            int Rule_hits = 0;
            kSession.setGlobal("Rule1_hits", Rule_hits);
            
            br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine()) != null){
				
				Object[] raw = line.split(delimiter);
				char categoricalProperty = raw[0].toString().toCharArray()[0];
				double gaussianProperty = Double.parseDouble(raw[1].toString());
				int randomProperty = Integer.parseInt(raw[2].toString());
			
				DataPacket  packet = new DataPacket(categoricalProperty, gaussianProperty, randomProperty);
	            kSession.insert(packet);
	            kSession.fireAllRules();
			}
            
			// long now = System.currentTimeMillis();
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy HH:mm:ss");
			long now = System.currentTimeMillis();
			long duration = now-startTime;

			long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) - 
					TimeUnit.MINUTES.toSeconds(minutes);
			long millis = duration - TimeUnit.SECONDS.toMillis(seconds);
			String durationToString = String.format("%02d min, %02d sec, %03d ms",
					minutes, seconds, millis
					);
            System.out.println("Duration = " + durationToString);
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//    
//    public class Helper(){
//    	public static void log(){
//    		
//    	}
//    }   


}



