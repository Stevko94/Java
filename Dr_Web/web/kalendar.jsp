<%@page import="moduls.Doctors"%>
<%@page import="org.hibernate.SQLQuery"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="moduls.Appointments"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<!DOCTYPE html>
<%Session s = moduls.HibernateUtil.getSF().openSession();
String u = (String)session.getAttribute("userloged");
String dr = (String)session.getAttribute("doctorloged");
List<Appointments> app;
if(dr==null){Query q = s.getNamedQuery("Appointments.findByUsername");
 q.setParameter("username", u);
 app =q.list();
}else{ Doctors drm = (Doctors)s.get(Doctors.class, Integer.parseInt(dr));
app = drm.getAppointmentsList();
}

%>
<html>
    <head>
        <title>Calendar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="cal.css">
    </head>
    <body><div id="drapmk"></div>
        <div class="wraper">
            <a href="./Logout">Logout</a>
		<h2 id="mounth"></h2>
		<table>
                    <th>Sun</th><th>Mon</th><th>Tue</th><th>Wen</th><th>Thur</th><th>Fri</th><th>Sat</th>
			<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
			<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
			<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
			<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
			<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
		</table>
	  </div>
	   <script>
	   var date = new Date();
            var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
            var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
            var mesec = date.getMonth();
			var mounts =["Jan","Feb","Mar","Apr","May","Jun","Jul","Avg","Sep","Oct","Nov","Dec"];
			var setmounth= document.getElementById("mounth").innerHTML=mounts[mesec];
			var zadnji =lastDay.getDay()+29;
            var prvi=firstDay.getDay();
          var c=document.body.getElementsByTagName("td");
       for( i=prvi;i<c.length;i++){c[i].innerHTML=i-prvi+1;}
	     var a= document.body.getElementsByTagName("td");
             var divpart= document.createDocumentFragment();
          for( i=0;i<a.length;i++){if((a[i].innerText)>zadnji){a[i].innerHTML='';}}
             for(i=0;i<a.length;i++){var k= a[i];
                  <%  for(Appointments a:app){ String atime= a.getAtime();
               String[] parts=atime.split(" ");
               String da=parts[1];
               String[] part= da.split("/");
               String day = part[0];
               String mounth=part[1];%> 
               if((k.innerText)==<%=day%>&&(mesec+1)==<%=mounth%>){
                               var div= document.createElement("div");
				div.innerHTML='<%=a.getUsername()+" "+parts[0]+"h"%>';
				var atr = document.createAttribute("class");
				atr.value="event";
				div.setAttributeNode(atr); 
				divpart.appendChild(div);
                            }<%}%>
                            k.appendChild(divpart);}
                        if(<%=dr%>!=null){var xhreq= new XMLHttpRequest();
                             xhreq.open("GET","form.html",false);
                             xhreq.send(null);
                             document.getElementById("drapmk").innerHTML=xhreq.responseText;
    }
        </script>
    </body>
</html>