package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewPet {
	@JsonProperty("id")
	private int id;
	@JsonProperty("category")
	private PetCategory category;
	@JsonProperty("name")
	private String name;
	@JsonProperty("photoUrls")
	private String[] photoUrls;
	@JsonProperty("tags")
	private PetTags[] tags;
	@JsonProperty("status")
	private String status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory getCategory() {
		return category;
	}
	public void setCategory(PetCategory category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public PetTags[] getTags() {
		return tags;
	}
	public void setTags(PetTags[] tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



}
