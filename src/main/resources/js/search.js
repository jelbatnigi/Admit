$(document).ready(function() {
  $('#searchForm').submit(function (event) {
     event.preventDefault();
     // alert($('#startId').val() + " " + $('#lastId').val());
     startId = $('#startId').val();
     lastId = $('#lastId').val();
     if(startId > lastId)
     {
        alert("Start Event Id must be smaller than End Event Id");
     }
    $.ajax({
        url: '/rest/searchEvents/'+startId+'/'+lastId
    }).then(function(data) {
    table = '<br><br><table class="table table-bordered"><tr><th>EventId</th><th>userId</th><th>NumberOfTIckets</th></tr>';
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