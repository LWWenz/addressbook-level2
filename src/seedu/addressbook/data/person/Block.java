package seedu.addressbook.data.person;

public class Block {

	private String _block;
	
	public Block(String block){
		_block = block;
	}
	
	public String getBlock() {
		return _block;
	}
	
	public void updateBlock(String block){
		_block = block;
	}
}
