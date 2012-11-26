package topoos.Objects;

public class VisibleDevice {

	private String Id = null;
	private String Name = null;
	private Integer Model = null;
	private Boolean isLogical = null;

	public VisibleDevice(String id, String name, Integer model,
			Boolean isLogical) {
		super();
		Id = id;
		Name = name;
		Model = model;
		this.isLogical = isLogical;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getModel() {
		return Model;
	}

	public void setModel(Integer model) {
		Model = model;
	}

	public Boolean getIsLogical() {
		return isLogical;
	}

	public void setIsLogical(Boolean isLogical) {
		this.isLogical = isLogical;
	}
}