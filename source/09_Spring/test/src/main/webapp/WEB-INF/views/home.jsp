<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<link href="https://cdn.jsdelivr.net/gh/ka215/jquery.timeline@main/dist/jquery.timeline.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/gh/ka215/jquery.timeline@main/dist/jquery.timeline.min.js"></script>
	<script>
		$(function(){
			$('#myTimeline').Timeline({
				  type: "bar",
				  startDatetime: "2023-04-18 00:00",
				  endDatetime: "2023-04-30 00:00",
				  scale: "day",
				  rowHeight: 36,
				  minGridSize: 100,
				  rows: 6,
				  shift: true,
			});
		});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- Timeline Block -->
<div id="myTimeline">
  <ul class="timeline-events">
    <li data-timeline-node="{ start:'2019-02-26 10:00',end:'2019-02-26 13:00',content:'<p>Event Body...</p>' }">Event Label</li>
    <li data-timeline-node="{ start:'2019-03-01 23:10',end:'2019-03-02 1:30' }">
      <span class="event-label">Event Label</span>
      <span class="event-content"><p>Event Body...</p></span>
    </li>
  </ul>
</div>

</body>
</html>
