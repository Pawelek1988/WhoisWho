package ldaptest;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


public class ActiveBean {

	private String userId = "Administrator";
	private String userPass = "zzg$12uz";
	
	private String base = "DC=flamant,DC=com";
	private String dn = "cn=" + userId + "," + "CN=Users," + base; 
	
	public String User = "pww";
	
	public String name;
	public String phone;
	public String company;
	public String Department;
	
	public ArrayList arrayUserGroup = new ArrayList();
	
	
	
	
	public ArrayList getArrayUserGroup() {
		return arrayUserGroup;
	}


	public void setArrayUserGroup(ArrayList arrayUserGroup) {
		this.arrayUserGroup = arrayUserGroup;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public SearchResult srLdapUser;
	public SearchResult getSrLdapUser() {
		return srLdapUser;
	}


	public void setSrLdapUser(SearchResult srLdapUser) {
		this.srLdapUser = srLdapUser;
	}


	public String getPrimaryGroupSID() {
		return primaryGroupSID;
	}


	public void setPrimaryGroupSID(String primaryGroupSID) {
		this.primaryGroupSID = primaryGroupSID;
	}


	public String getPrimaryGroupName() {
		return primaryGroupName;
	}



	public void setPrimaryGroupName(String primaryGroupName) {
		this.primaryGroupName = primaryGroupName;
	}


	public String primaryGroupSID;
	public String primaryGroupName;
	
	
	// Set up the environment for creating the initial context
	Hashtable<String, Object> env = new Hashtable<String, Object>();

	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserPass() {
		return userPass;
	}



	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}



	public String getBase() {
		return base;
	}



	public void setBase(String base) {
		this.base = base;
	}



	public String getDn() {
		return dn;
	}



	public void setDn(String dn) {
		this.dn = dn;
	}



	public Hashtable<String, Object> getEnv() {
		return env;
	}



	public void setEnv(Hashtable<String, Object> env) {
		this.env = env;
	}

	
	

	public void doSearch() {

		// Authenticate as S. User and password "mysecret"
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
				
			if(userId != null) {
			env.put(Context.SECURITY_PRINCIPAL, dn);
			}
				
			if(userPass != null) {
			env.put(Context.SECURITY_CREDENTIALS, userPass);
			}
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://flamant.com:389");
				
			env.put("java.naming.ldap.attributes.binary", "objectSID");
			
	        // the following is helpful in debugging errors
	        //env.put("com.sun.jndi.ldap.trace.ber", System.err);
			
			// Create the initial context

			try {
				
				DirContext ctx = new InitialDirContext(env);
				

				
				//1) lookup the ldap account
				srLdapUser = findAccountByAccountName(ctx, base);
				
//		        //2) get the SID of the users primary group
//		        primaryGroupSID = getPrimaryGroupSID(srLdapUser);
//				
//		        //3) get the users Primary Group
//		        primaryGroupName = findGroupBySID(ctx, base, primaryGroupSID);
		        
//		        System.out.println(srLdapUser);
		        
		        
		        
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ... do something useful with ctx
		
			
	}
	
    public String findGroupBySID(DirContext ctx, String ldapSearchBase, String sid) throws NamingException {
        
        String searchFilter = "(&(objectClass=group)(objectSid=" + sid + "))";

        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

        if(results.hasMoreElements()) {
            SearchResult searchResult = (SearchResult) results.nextElement();

            //make sure there is not another item available, there should be only 1 match
            if(results.hasMoreElements()) {
                System.err.println("Matched multiple groups for the group with SID: " + sid);
                return null;
            } else {
                return (String)searchResult.getAttributes().get("sAMAccountName").get();
            }
        }
        return null;
    }
	
	
	
    public SearchResult findAccountByAccountName(DirContext ctx, String ldapSearchBase) throws NamingException {

    	
    	
    	
    	ArrayList arrayUserName = new ArrayList();
    	ArrayList arrayUserPhone = new ArrayList();
    	
    	
        String searchFilter = "(&(objectCategory=user)(memberOf=*))";

        SearchControls searchControls = new SearchControls();
        
//		String[] attrIDs = { "cn" };
//		searchControls.setReturningAttributes(attrIDs);
        
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

        SearchResult searchResult = null;
        while(results.hasMoreElements()) {
             searchResult = (SearchResult) results.nextElement();
             javax.naming.directory.Attributes attrs = searchResult.getAttributes();
             String groupName = attrs.get("cn").toString();
//           String name = attrs.get("name").toString();
//           String phone = attrs.get("ipphone").toString();
//           String company = attrs.get("company").toString();
//           String Department = attrs.get("Department").toString();
             
//           	 arrayUserPhone.add(phone);	
//             arrayUserName.add(name);
             arrayUserGroup.add(groupName);
             System.out.println(groupName); 
        }

//        System.out.println(arrayUserGroup);
//        System.out.println(arrayUserName);

        
//      String name = searchResult.getAttributes().get("name").toString();
//      String phone = searchResult.getAttributes().get("ipphone").toString();
//      String company = searchResult.getAttributes().get("Company").toString();
//      String Department = searchResult.getAttributes().get("Department").toString();
      
//      System.out.println(searchResult);
//      System.out.println(name);
//      System.out.println(phone);
//      System.out.println(company);
//      System.out.println(Department);    
        
        
    return searchResult;
}
	
    
    
    public String getPrimaryGroupSID(SearchResult srLdapUser) throws NamingException {
        byte[] objectSID = (byte[])srLdapUser.getAttributes().get("objectSid").get();
        String strPrimaryGroupID = (String)srLdapUser.getAttributes().get("primaryGroupID").get();
        
        String strObjectSid = decodeSID(objectSID);
        
        return strObjectSid.substring(0, strObjectSid.lastIndexOf('-') + 1) + strPrimaryGroupID;
    }
	
public static String decodeSID(byte[] sid) {
        
        final StringBuilder strSid = new StringBuilder("S-");

        // get version
        final int revision = sid[0];
        strSid.append(Integer.toString(revision));
        
        //next byte is the count of sub-authorities
        final int countSubAuths = sid[1] & 0xFF;
        
        //get the authority
        long authority = 0;
        //String rid = "";
        for(int i = 2; i <= 7; i++) {
           authority |= ((long)sid[i]) << (8 * (5 - (i - 2)));
        }
        strSid.append("-");
        strSid.append(Long.toHexString(authority));
        
        //iterate all the sub-auths
        int offset = 8;
        int size = 4; //4 bytes for each sub auth
        for(int j = 0; j < countSubAuths; j++) {
            long subAuthority = 0;
            for(int k = 0; k < size; k++) {
                subAuthority |= (long)(sid[offset + k] & 0xFF) << (8 * k);
            }
            
            strSid.append("-");
            strSid.append(subAuthority);
            
            offset += size;
        }
        
        return strSid.toString();    
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
