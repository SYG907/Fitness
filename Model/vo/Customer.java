package Model.vo;

public class Customer {
	String custName;		// 고객명
	String custTel;			// 전화번호
	String custAddr;		// 주소

	
	
public Customer(){}
public Customer(String custName, String custTel, String custAddr) {
		this.custName = custName;
		this.custTel = custTel;
		this.custAddr = custAddr;

	}

public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}

public String getCustTel() {
	return custTel;
}

public void setCustTel(String custTel) {
	this.custTel = custTel;
}

public String getCustAddr() {
	return custAddr;
}

public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
}


}
	
	
	
	

