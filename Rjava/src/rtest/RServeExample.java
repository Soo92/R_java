package rtest;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RServeExample {
	public static void getString() throws RserveException, REXPMismatchException { 
		RConnection rc = new RConnection(); 
		REXP x = rc.eval("R.version.string"); 
		System.out.println("R 버전 정보 : " + x.asString()); 
		rc.close(); 
	}
	public static void getInteger() throws RserveException, REXPMismatchException { 
		RConnection rc = new RConnection(); 
		REXP x = rc.eval("length(LETTERS)"); 
	   System.out.println("알파벳 갯수 : " + x.asInteger());
	   rc.close(); 
	}
	public static void getIntegers() throws REngineException, REXPMismatchException { 
		RConnection rc = new RConnection(); 
		double[] dataX = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 
		rc.assign("x", dataX); 
		rc.eval("y <- x + 10"); 
		int[] resultX = rc.eval("y").asIntegers(); 
			for (int i = 0; i < resultX.length; i++) { 
				System.out.println(resultX[i]); 
			}   
		rc.close(); 
		
	}
	public static void main(String[] args) throws RserveException, REXPMismatchException {
		// TODO Auto-generated method stub
		System.out.println("------------ R 에서 버젼정보 가져오기 --------------"); 
		RServeExample.getString(); 
		System.out.println("------------ R 에서 정수 데이터 가져오기 --------------"); 
		RServeExample.getInteger(); 
	}

}
