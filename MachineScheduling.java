import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//$Id$

public class MachineScheduling {
	
	public static void main(String args[]) {
		HashMap<Integer,List> map=new HashMap<Integer,List>();
	//map.put(17,Arrays.asList(20));
	//	map.put(0,Arrays.asList(3));
	//	map.put(15,Arrays.asList(18));
	//	map.put(2,Arrays.asList(10));
		map.put(2,Arrays.asList(4));
		map.put(7,Arrays.asList(9));
		int totalmachine=0;

		HashMap machineRunning=new HashMap();
		List keyset=Arrays.asList(map.keySet().toArray());
		Collections.sort(keyset);

		int len=keyset.size();
		for(int i=0;i<len;i++) {
			int startTime=(int)keyset.get(i);
			List endTimeList=map.get(startTime);
			if(i==0) {
				for(int j=0;j<endTimeList.size();j++) {
					totalmachine++;
					machineRunning.put(totalmachine, endTimeList.get(j));
				}

			}else {
				for(int l=0;l<endTimeList.size();l++) {
					int currentTime=(int)endTimeList.get(l);
					boolean matchFound=false;
					for(int k=1;k<=totalmachine;k++) {
						int lastEndTime=(int)machineRunning.get(k);
						if(startTime>lastEndTime ) {
							matchFound=true;
							machineRunning.put(k,currentTime);
							break;
						}

					}
					if(!matchFound) {
						totalmachine++;
						machineRunning.put(totalmachine, currentTime);
					}
				}
			}


		}
		System.out.println(" Total number of machine " + totalmachine);
	}

}
