package app.entities;

public class Carport {
	private int width;
	private int depth;
	private int height;
	private PartsList partsList;
	// Illustration in future
	private final int maxPostDistanceWidth = 500;
	private final int maxPostDistanceDepth = 400;

	// === Material Specifications ===
	private int postQuantity;
	private int postLength;
	private int depthSternQuantity = 2; // Maybe 2 per side? Maybe that's in the parts list
	private int depthSternLength;
	private int widthSternQuantity = 2;
	private int widthSternLength;
	private int rafterQuantity;
	private int rafterLength;
	private int purlinQuantity = 2;	// I think it'll always be 2
	private int purlinLength;

	// === Constructors ===
	public Carport(int width, int depth, int height) {
		this.width = width;
		this.depth = depth;
		this.height = height;

		partsList = new PartsList();
	}

	public Carport() {
		partsList = new PartsList();
	}

	// === Methods ===

	// === Getters/Setters ===

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public PartsList getPartsList() {
		return partsList;
	}

	public void setPartsList(PartsList partsList) {
		this.partsList = partsList;
	}

	public int getPostQuantity() {
		return postQuantity;
	}

	public void setPostQuantity(int postQuantity) {
		this.postQuantity = postQuantity;
	}

	public int getPostLength() {
		return postLength;
	}

	public void setPostLength(int postLength) {
		this.postLength = postLength;
	}

	public int getDepthSternQuantity() {
		return depthSternQuantity;
	}

	public void setDepthSternQuantity(int depthSternQuantity) {
		this.depthSternQuantity = depthSternQuantity;
	}

	public int getDepthSternLength() {
		return depthSternLength;
	}

	public void setDepthSternLength(int depthSternLength) {
		this.depthSternLength = depthSternLength;
	}

	public int getWidthSternQuantity() {
		return widthSternQuantity;
	}

	public void setWidthSternQuantity(int widthSternQuantity) {
		this.widthSternQuantity = widthSternQuantity;
	}

	public int getWidthSternLength() {
		return widthSternLength;
	}

	public void setWidthSternLength(int widthSternLength) {
		this.widthSternLength = widthSternLength;
	}

	public int getRafterQuantity() {
		return rafterQuantity;
	}

	public void setRafterQuantity(int rafterQuantity) {
		this.rafterQuantity = rafterQuantity;
	}

	public int getRafterLength() {
		return rafterLength;
	}

	public void setRafterLength(int rafterLength) {
		this.rafterLength = rafterLength;
	}

	public int getPurlinQuantity() {
		return purlinQuantity;
	}

	public void setPurlinQuantity(int purlinQuantity) {
		this.purlinQuantity = purlinQuantity;
	}

	public int getPurlinLength() {
		return purlinLength;
	}

	public void setPurlinLength(int purlinLength) {
		this.purlinLength = purlinLength;
	}
}
