<!DOCTYPE html>

<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<jsp:useBean id="Active" scope="request" class="ldaptest.ActiveBean"/>

<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description" content="Metro, a sleek, intuitive, and powerful framework for faster and easier web development for Windows Metro Style.">
    <meta name="keywords" content="HTML, CSS, JS, JavaScript, framework, metro, front-end, frontend, web development">
    <meta name="author" content="Sergey Pimenov and Metro UI CSS contributors">

    <link rel='shortcut icon' type='image/x-icon' href='favicon.ico' />
    <title>Tables :: Metro UI CSS - List of users</title>

    <link href="css/metro.css" rel="stylesheet">
    <link href="css/metro-icons.css" rel="stylesheet">
    <link href="css/metro-responsive.css" rel="stylesheet">
    <link href="css/metro-schemes.css" rel="stylesheet">

    <link href="css/docs.css" rel="stylesheet">

    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/metro.js"></script>
    <script src="js/docs.js"></script>
    <script src="js/prettify/run_prettify.js"></script>
    <script src="js/ga.js"></script>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

</head>
<body>


        <div class="app-bar darcula">
           <a class="app-bar-element">WhoIsWho</a>
           <span class="app-bar-divider place-right"></span> 
           <a href="http://intranet.flamant.com/portal.cshtml?User=@LUser&Name=@LName" class="app-bar-element place-right square-button bg-transparent fg-white bg-hover-dark no-border"><span class="mif-switch"></span></a>
           <a class="app-bar-element place-right">@LName</a>
        </div>


        <div class="toolbar">
            <div class="toolbar-section"> 
                <form action="active" method="get">
                
<!--                 	<input type="submit" value="Submit"/> -->
                
                    <div class="input-control text">
                         <input type="text" name="search" placeholder="Search">
                    </div>
                     <div class="input-control select">
                             <select>
                                <option>Flamant</option>
                                <option>IDL</option>
                                <option>Shops</option>
                            </select>
                    </div>
                     <div class="input-control select">
                             <select>
                                <option>IT</option>
                                <option>Purchase</option>
                                <option>Sales</option>
                            </select>
                    </div>
                     <button class="toolbar-button" name="Button" value="search"><span class="mif-search"></span></button>

                </form>
            </div>
        </div>


        <div class="example">
        
        	<form action="active" method="get">
            <table class="table striped hovered border bordered">
                <thead>
                <tr>
                    <th class="sortable-column ">Details</th>
                    <th class="sortable-column sort-asc">Picture</th>
                    <th class="sortable-column ">Name</th>
                	<th class="sortable-column ">Phone Number</th>
                    <th class="sortable-column sort-asc">Company</th>
                    <th class="sortable-column ">Department</th>
                
                </tr>
                </thead>
                <tbody>
                

                <tr>
                
                    <td>User info:</td>
                    <td> <jsp:getProperty name="Active" property="arrayUserGroup"/></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>bla</td>
                    
                    
                </tr>
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td>  -->
                    
<!--                 </tr> -->
<!--                                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
                    
                    
<!--                 </tr> -->
<!--                                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
                    
                    
<!--                 </tr> -->
<!--                                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td>  -->
<!--                 </tr> -->
<!--                                                <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
                    
                    
<!--                 </tr> -->
<!--                                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
                    
                    
<!--                 </tr> -->
<!--                                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!--                     <td>a</td> -->
<!--                     <td>b</td> -->
<!--                     <td>c</td> -->
<!--                     <td>d</td> -->
<!--                     <td>e</td> -->
<!--                     <td>f</td>  -->
<!--                 </tr> -->
                </tbody>
            </table>
		</form>
        </div>

    </div>
</body>
</html>