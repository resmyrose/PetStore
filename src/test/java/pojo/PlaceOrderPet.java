package pojo;

	import com.fasterxml.jackson.annotation.JsonProperty;

	public class PlaceOrderPet {
		@JsonProperty("id")
		private int id;
		@JsonProperty("petId")
		private int petId;
		@JsonProperty("quantity")
		private int quantity;
		@JsonProperty("shipDate")
		private String shipDate;
		@JsonProperty("status")
		private String status;
		@JsonProperty("complete")
		private String complete;
		

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPetId() {
			return petId;
		}
		public void setPetId(int petId) {
			this.petId = petId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getShipDate() {
			return shipDate;
		}
		public void setShipDate(String shipDate) {
			this.shipDate = shipDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus() {
			this.status = status;
		}
		public String getComplete() {
			return complete;
		}
		public void setComplete(String complete) {
			this.complete = complete;
		}


	}



