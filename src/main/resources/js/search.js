$(document).ready(function() {
  $('#searchForm').submit(function (event) {
     event.preventDefault();
     // alert($('#startId').val() + " " + $('#lastId').val());
     startId = $('#startId').val();
     lastId = $('#lastId').val();
    $.ajax({
        url: '/rest/searchEvents/'+startId+'/'+lastId
    }).then(function(data) {
    table = '<br><br><table border="1""><tr><th>EventId</th><th>userId</th><th>NumberOdTIckets</th></tr>';
    rows = '';
    $.each(data, function() {
        rows += '<tr><td>' + this.purchaseId + '</td>' +
                '<td>' + this.userId + '</td>' +
                '<td>' + this.numberOfTickets + '</td></tr>';
        });
        results = table+rows;
       if($('#results').length)
       {
           $('#results').remove();
       }
       resultElement = '<div id="results"></div>'
       $('#main').append(resultElement);
       $('#results').append(results);
    });
    });
});