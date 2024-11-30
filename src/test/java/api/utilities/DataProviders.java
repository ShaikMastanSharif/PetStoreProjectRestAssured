package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException{
		String path=System.getProperty("user.dir")+".//testdata//restassured.xlsx";
		ExcelUtilies xlutil = new ExcelUtilies(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String apidata[][]= new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				apidata[i-1][j] =xlutil.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	@DataProvider(name="UserNames")
	public String [] getUserData() throws IOException {
		String path=System.getProperty("user.dir")+".//testdata//restassured.xlsx";
		ExcelUtilies xlities1=new ExcelUtilies(path);
		int row=xlities1.getRowCount("Sheet1");
		
		String apidata[]=new String[row];
		for(int i=1;i<=row;i++) {
			apidata[i-1]=xlities1.getCellData("Sheet1", i,1);
		}
		return apidata;
		
	}

}
