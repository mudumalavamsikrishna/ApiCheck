
public class Result {
	private String full_address;

	private String property_id;

	private String bin_collection_day;

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}

	public String getProperty_id() {
		return property_id;
	}

	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	public String getBin_collection_day() {
		return bin_collection_day;
	}

	public void setBin_collection_day(String bin_collection_day) {
		this.bin_collection_day = bin_collection_day;
	}

	@Override
	public String toString() {
		return "ClassPojo [full_address = " + full_address + ", property_id = " + property_id
				+ ", bin_collection_day = " + bin_collection_day + "]";
	}
}