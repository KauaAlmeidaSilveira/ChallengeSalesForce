package br.com.fiap.beans;

public class Client {

    private String name;
    private String email;
    private Integer age;
    private Double vlrConsult;
    private Address address;

	public Client(String name, String email, Integer age, Double vlrConsult, Address address) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.vlrConsult = vlrConsult;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getVlrConsult() {
        return vlrConsult;
    }

    public void setVlrConsult(Double vlrConsult) {
        this.vlrConsult = vlrConsult;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
        	   "Email: " + email + "\n" +
               "Age: " + age + "\n" +
               "Value consult: " + vlrConsult + "\n" +
               "Your address: " + address.getLogradouro();
    }
}
