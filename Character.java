public abstract class Character {
	private String name;
	private int statLuck;
	private int statStrenght;
	private int statIntelligence;
	private int statResistance;
	
	public Character(String name, int statLuck, int statStrenght, int statIntelligence, int statResistance){
		this.name = name;
		this.statLuck = statLuck;
		this.statStrenght = statStrenght;
		this.statIntelligence = statIntelligence;
		this.statResistance = statResistance;
	}
	
	public String sayName(){
		return "Hey my name is " + name + " lets go to this adventure";
	}
	
	public void showStats(){
		System.out.println("Luck: " + statLuck + " | Strenght: " + statStrenght + " | Intelligence: " + statIntelligence + " | Resistance: " + statResistance);
	}
	
	public abstract void showBackgroundHistory();
	
	public int getStatLuck(){
		return statLuck;
	}
	
	public int getStatStrenght(){
		return statStrenght;
	}
	
	public int getStatIntelligence(){
		return statIntelligence;
	}
	
	public int getStatResistence(){
		return statResistance;
	}

	public String getName() {
		return name;
	}
}