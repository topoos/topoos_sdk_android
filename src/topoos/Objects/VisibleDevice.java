package topoos.Objects;
/**
 * Class that implements a visible device
 * @author MAJS
 *
 */
public class VisibleDevice {

	private String Id = null;
	private String Name = null;
	private Integer Model = null;
	private Boolean isLogical = null;
	/**
	 * 
	 * @param id
	 * @param name
	 * @param model
	 * @param isLogical
	 */
	public VisibleDevice(String id, String name, Integer model,
			Boolean isLogical) {
		super();
		Id = id;
		Name = name;
		Model = model;
		this.isLogical = isLogical;
	}
	/**
	 * get the device id
	 * @return the device id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * 
	 * @param id
	 * 		set the device큦 id
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * get the name of the device
	 * @return
	 * 		name of the device
	 */
	public String getName() {
		return Name;
	}
	/**
	 * 
	 * @param name
	 * 		set the device큦 name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * get the model of the device
	 * @return 
	 * 		model of the device
	 */
	public Integer getModel() {
		return Model;
	}
	/**
	 * 
	 * @param model
	 * 		set device큦 model
	 */
	public void setModel(Integer model) {
		Model = model;
	}
	/**
	 * get the type of the device true if it is logical
	 * @return
	 * 		if is a logical device
	 */
	public Boolean getIsLogical() {
		return isLogical;
	}
	/**
	 * 
	 * @param isLogical
	 * 		set device큦 type
	 */
	public void setIsLogical(Boolean isLogical) {
		this.isLogical = isLogical;
	}
}