package iva.com.beispiele;

public class ObjMitBuilder {
	private String name;
	private Integer alter;
	private String gen;

	private ObjMitBuilder(MeinBuilder builder) {
		// TODO Auto-generated constructor stub
		this.name = builder.name;
		this.alter = builder.alter;
		this.gen = builder.gen;
		System.out.println("im Object----");
	}

	public String getGen() {
		return gen;
	}

	public String getName() {
		return name;
	}

	public Integer getAlter() {
		return alter;
	}
	
	
	public static class MeinBuilder {
		private String gen;
		private String name;
		private Integer alter;
		
		
		public MeinBuilder(String gen) {
			// TODO Auto-generated constructor stub
			this.gen = gen;
			System.out.println("im Builder----");
		}

		public MeinBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public MeinBuilder setAlter(Integer alter) {
			this.alter = alter;
			return this;
		}
		
		public ObjMitBuilder build(){
			
			ObjMitBuilder ref = new ObjMitBuilder(this);
			return ref;
		}

	}
	//System.out.println(this.name + " " +this.alter);

}
