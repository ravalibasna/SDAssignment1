package binarysearch.binarysearch;

import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class hw3 {
	 
	public static int binarySearch( Comparable [ ] a, Comparable x )
  {
      int first = 0;
      int last = a.length - 1;
      int mid;

      while( first <= last )
      {
          mid = ( first + last ) / 2;

          if( a[ mid ].compareTo( x ) < 0 )
              first = mid + 1;
          else if( a[ mid ].compareTo( x ) > 0 )
              last = mid - 1;
          else
              return mid;
      }

      return -1;     // NOT_FOUND = -1
  }


public static void main(String[] args) throws Exception {
	
   
Options options = new Options();

Option type = new Option("type", "type", true, "data type of the input");
options.addOption(type);

Option key = new Option("key", "key", true, "key element to be searched");
options.addOption(key);

Option list = new Option("list", "list", true, "list of inputs to be searched");

options.addOption(list);

CommandLineParser commandLineParser = new DefaultParser();

CommandLine commandLine;
try{
commandLine = commandLineParser.parse(options, args);

String typeelement = commandLine.getOptionValue("type");
String keyelement = commandLine.getOptionValue("key");
String firstelement = commandLine.getOptionValue("list");
List<String> listelements = commandLine.getArgList();


String [ ] arr = new String [listelements.size()+1];
arr[0]=firstelement;

for (int i=1;i<listelements.size()+1;i++)
	  arr[i]=listelements.get(i-1);
int c;
if(typeelement.compareTo("s")==0){
	c=binarySearch(arr,keyelement);
	if(c==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
}else if(typeelement.compareTo("i")==0){
	 c=binarySearch(arr,keyelement);
	if(c==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
	
}
}
catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	}




}

}
