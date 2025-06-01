package Com.arch.mvc.model;

public class Student 
{
	private String id;
	private String name;
	private String age;
	private String email;
	private String mobile;
	
	public Student(String id, String name, String age, String mobile,String email) 
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
}
