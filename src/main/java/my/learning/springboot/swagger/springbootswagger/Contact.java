package my.learning.springboot.swagger.springbootswagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the Contact")
public class Contact {

	@ApiModelProperty(notes = "The unique id of the contact")
	private String id;
	@ApiModelProperty(notes = "The Person's Name")
	private String name;
	@ApiModelProperty(notes = "The Person's Phone Number")
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
