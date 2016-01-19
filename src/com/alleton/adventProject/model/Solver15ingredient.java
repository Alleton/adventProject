package com.alleton.adventProject.model;

public class Solver15ingredient {

	private String ingredient ;


	private int capacity ;
	private int durability;
	private int flavor;
	private int texture;
	private int calories;
	
	
	
	
	/**
	 * @return the ingredient
	 */
	public String getIngredient() {
		return ingredient;
	}
	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the durability
	 */
	public int getDurability() {
		return durability;
	}
	/**
	 * @param durability the durability to set
	 */
	public void setDurability(int durability) {
		this.durability = durability;
	}
	/**
	 * @return the flavor
	 */
	public int getFlavor() {
		return flavor;
	}
	/**
	 * @param flavor the flavor to set
	 */
	public void setFlavor(int flavor) {
		this.flavor = flavor;
	}
	/**
	 * @return the texture
	 */
	public int getTexture() {
		return texture;
	}
	/**
	 * @param texture the texture to set
	 */
	public void setTexture(int texture) {
		this.texture = texture;
	}
	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}
	/**
	 * @param calories the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public String ingredientToString (){
		StringBuilder builder = new StringBuilder();
		builder.append( " name    = " + this.getIngredient()  + "  : " ) ;
		builder.append( " capacity   =  " + this.getCapacity() + " : " ) ;
		builder.append( " durability   =  " + this.getDurability() + " : " ) ;
		builder.append( " flavor      =  " + this.getFlavor() + " :"  ) ;
		builder.append( " texture   =  " + this.getTexture()  + "  = " ) ;
		builder.append( " calories   =  " + this.getCalories()  + "  = " ) ;
		
		return  builder.toString();
	}
	
	@Override
	public String toString() {
		return ingredientToString();
	}
}
