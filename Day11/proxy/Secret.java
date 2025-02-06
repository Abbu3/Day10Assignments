package com.java.proxy;

public interface Secret {
	
	void Objectkey(String key);

}


class SecretImpl implements Secret {

	@Override
	public void Objectkey(String key) {
		System.out.println(key+" key found");
	}
	
}


class SecretProxy implements Secret {
	
	private boolean isAdmin;
	private Secret secret;
	
	public SecretProxy(String user, String password) {
		if(user.equals("abbu") && password.equals("#Abdul123")) {
			isAdmin = true;
			secret = new SecretImpl();
		}
	}

	@Override
	public void Objectkey(String key) {
		
		if(isAdmin) {
			secret.Objectkey(key);
		} else {
			System.out.println("sorry, try agian for key");
		}
		
	}
	
}