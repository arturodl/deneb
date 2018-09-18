<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Parking Application by Arct-Applications</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta charset="utf-8" />
       
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
	<script src="<c:url value="/resources/js/plugins/datepicker/bootstrap-datepicker.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/plugins/datepicker/locale/bootstrap-datepicker.es.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/plugins/wickedpicker/wickedpicker.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />" > </script>
	<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet"/>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" id="bs-css"/>	
	<link href="<c:url value="/resources/css/plugins/datepicker/bootstrap-datepicker3.min.css" />" rel="stylesheet" id="bsdp-css"/>
	<link href="<c:url value="/resources/css/plugins/wickedpicker/wickedpicker.min.css" />" rel="stylesheet"/>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link href="<c:url value="/resources/css/stylesforviews/dashboard.css" />" rel="stylesheet"/>
	
	
	<script type="text/javascript" >
		
		function lanzaAlerta(){
			alert('Lanzando alerta');
		}
		
		function getVehiclesView() {
			$.ajax({
				type : "GET",
				//contentType : "application/json",
				url : 'vehiculo/gestion',
				success : function(resultado, status, xhr) {
					$('#divMainContent').html(resultado);
					$('#h1currentOption').html('Register of Vehicles');	
				},
				error : function(xhr, status, error) {
					console.log("ERROR: ", xhr);
					alert('Error, status is: '+status);					
				},
				complete: function(xhresponse,status){
					//alert('Request Complete: '+status);
				}
			});		
		}
		
		function getListVehiclesView() {
			$.ajax({
				type : "GET",
				//contentType : "application/json",
				url : 'vehiculo/listado',
				success : function(resultado, status, xhr) {
					$('#divMainContent').html(resultado);
					$('#h1currentOption').html('Vehicles Resumen');	
				},
				error : function(xhr, status, error) {
					console.log("ERROR: ", xhr);
					alert('Error, status is: '+status);					
				},
				complete: function(xhresponse,status){
					//alert('Request Complete: '+status);
				}
			});		
		}
		
		function getViewBinnacleList() {
			$.ajax({
				type : "GET",
				//contentType : "application/json",
				url : 'bitacora/resumen',
				success : function(resultado, status, xhr) {
					$('#divMainContent').html(resultado);
					$('#h1currentOption').html('Binaccle Resumen');	
				},
				error : function(xhr, status, error) {
					console.log("ERROR: ", xhr);
					alert('Error, status is: '+status);					
				},
				complete: function(xhresponse,status){
					//alert('Request Complete: '+status);
				}
			});		
		}
		
		$(document).ready(function(){
		   /*  Submit form using Ajax */
		   $('a#linkChecking').click(function(e) {
			   getViewBinnacleList();			   
		   });
		   $('a#linkVehicles').click(function(e) {
			   getListVehiclesView();		   
		   });		  
		});
	
	</script>
	
</head>

<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">ParkingApp</a>
      <!--  <input class="form-control form-control-dark w-100" placeholder="Search" aria-label="Search" type="text">    -->
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sign out</a>
        </li>
      </ul>
</nav>

<div class="container-fluid">
	<div class="row">
	<nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a id="linkHome" class="nav-link" href="<c:url value="/index" />">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                  	<path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                  	<polyline points="9 22 9 12 15 12 15 22"></polyline>
                  </svg>
                  Home  <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a id="linkChecking" class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                  	<path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                  	<polyline points="13 2 13 9 20 9"></polyline>
                  </svg>
                  Checking
                </a>
              </li>
              <li class="nav-item">
                <a id="linkVehicles" class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                  	<path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                  	<polyline points="13 2 13 9 20 9"></polyline>
                  </svg>
                  Vehicles
                </a>
              </li>
              <li class="nav-item">
                <a id="linkUsers" class="nav-link" href="#" >
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                  	<path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                  	<circle cx="9" cy="7" r="4"></circle>
                  	<path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                  	<path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                  </svg>
                  Users
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#" id="nombreLink">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                  	<path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                  	<circle cx="9" cy="7" r="4"></circle>
                  	<path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                  	<path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                  </svg>
                  Customers
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2">
                  	<line x1="18" y1="20" x2="18" y2="10"></line>
                  	<line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line>
                  </svg>
                  Reports
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers">
                  	<polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                  	<polyline points="2 17 12 22 22 17"></polyline>
                  	<polyline points="2 12 12 17 22 12"></polyline>
                  </svg>
                  Integrations
                </a>
              </li>
            </ul>
         
          <!-- 
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Saved reports</span>
              <a class="d-flex align-items-center text-muted" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
              </a>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  Current month
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  Last quarter
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  Social engagement
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  Year-end sale
                </a>
              </li>
            </ul>
          -->
          </div>
        </nav>
	</div>	
</div>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 id="h1currentOption" class="h5">Parking Management Application</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <div class="btn-group mr-2">
                <button class="btn btn-sm btn-outline-secondary">Share</button>
                <button class="btn btn-sm btn-outline-secondary">Export</button>
              </div>
              <!-- 
              <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>
                This week
              </button>
               -->
            </div>            
          </div>

          <div id="divMainContent">
            <h5>Latest Records</h5> 
	          <div class="table-responsive">
	            <table class="table table-striped table-sm">
	              <thead>
	                <tr>
	                  <th>#</th>
	                  <th>Check in</th>
	                  <th>Check out</th>
	                  <th>License</th>
	                  <th>Model</th>
	                  <th>Trademark</th>
	                </tr>
	              </thead>
	              <tbody>
	                <tr>
	                  <td>1,001</td>
	                  <td>Lorem</td>
	                  <td>ipsum</td>
	                  <td>dolor</td>
	                  <td>sit</td>
	                  <td>sit</td>
	                </tr>
	                <tr>
	                  <td>1,002</td>
	                  <td>amet</td>
	                  <td>consectetur</td>
	                  <td>adipiscing</td>
	                  <td>elit</td>
	                  <td>elit</td>
	                </tr>
	                <tr>
	                  <td>1,003</td>
	                  <td>Integer</td>
	                  <td>nec</td>
	                  <td>odio</td>
	                  <td>Praesent</td>
	                  <td>Praesent</td>
	                </tr>
	                <tr>
	                  <td>1,003</td>
	                  <td>libero</td>
	                  <td>Sed</td>
	                  <td>cursus</td>
	                  <td>ante</td>
	                  <td>ante</td>
	                </tr>
	                <tr>
	                  <td>1,004</td>
	                  <td>dapibus</td>
	                  <td>diam</td>
	                  <td>Sed</td>
	                  <td>nisi</td>
	                  <td>nisi</td>
	                </tr>
	                <tr>
	                  <td>1,005</td>
	                  <td>Nulla</td>
	                  <td>quis</td>
	                  <td>sem</td>
	                  <td>at</td>
	                  <td>at</td>
	                </tr>
	                <tr>
	                  <td>1,006</td>
	                  <td>nibh</td>
	                  <td>elementum</td>
	                  <td>imperdiet</td>
	                  <td>Duis</td>
	                  <td>Duis</td>
	                </tr>
	                <tr>
	                  <td>1,007</td>
	                  <td>sagittis</td>
	                  <td>ipsum</td>
	                  <td>Praesent</td>
	                  <td>mauris</td>
	                  <td>mauris</td>
	                </tr>
	                <tr>
	                  <td>1,008</td>
	                  <td>Fusce</td>
	                  <td>nec</td>
	                  <td>tellus</td>
	                  <td>sed</td>
	                  <td>sed</td>
	                </tr>
	                <tr>
	                  <td>1,009</td>
	                  <td>augue</td>
	                  <td>semper</td>
	                  <td>porta</td>
	                  <td>Mauris</td>
	                  <td>Mauris</td>
	                </tr>
	                <tr>
	                  <td>1,010</td>
	                  <td>massa</td>
	                  <td>Vestibulum</td>
	                  <td>lacinia</td>
	                  <td>arcu</td>
	                  <td>arcu</td>
	                </tr>
	                <tr>
	                  <td>1,011</td>
	                  <td>eget</td>
	                  <td>nulla</td>
	                  <td>Class</td>
	                  <td>aptent</td>
	                  <td>aptent</td>
	                </tr>
	                <tr>
	                  <td>1,012</td>
	                  <td>taciti</td>
	                  <td>sociosqu</td>
	                  <td>ad</td>
	                  <td>litora</td>
	                  <td>litora</td>
	                </tr>
	                <tr>
	                  <td>1,013</td>
	                  <td>torquent</td>
	                  <td>per</td>
	                  <td>conubia</td>
	                  <td>nostra</td>
	                  <td>nostra</td>
	                </tr>
	                <tr>
	                  <td>1,014</td>
	                  <td>per</td>
	                  <td>inceptos</td>
	                  <td>himenaeos</td>
	                  <td>Curabitur</td>
	                  <td>Curabitur</td>
	                </tr>
	                <tr>
	                  <td>1,015</td>
	                  <td>sodales</td>
	                  <td>ligula</td>
	                  <td>in</td>
	                  <td>libero</td>
	                  <td>libero</td>
	                </tr>
	              </tbody>
	             </table>
	           </div>
	         </div>
        </main>
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>

</body>
</html>