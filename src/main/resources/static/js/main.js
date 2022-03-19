// $(document).ready(function () {
//
// 	var colors = ['#007bff', '#28a745', '#444444', '#c3e6cb', '#dc3545', '#6c757d'];
//
// 	var chBar = document.getElementById("chBar");
// 	var chartData = {
// 		labels: ["S", "M", "T", "W", "T", "F", "S"],
// 		datasets: [{
// 			data: [589, 445, 483, 503, 689, 692, 634],
// 			backgroundColor: colors[0]
// 		},
// 			{
// 				data: [209, 245, 383, 403, 589, 692, 580],
// 				backgroundColor: colors[1]
// 			},
// 			{
// 				data: [489, 135, 483, 290, 189, 603, 600],
// 				backgroundColor: colors[2]
// 			},
// 			{
// 				data: [639, 465, 493, 478, 589, 632, 674],
// 				backgroundColor: colors[4]
// 			}]
// 	};
//
// 	if (chBar) {
// 		new Chart(chBar, {
// 			type: 'bar',
// 			data: chartData,
// 			options: {
// 				scales: {
// 					xAxes: [{
// 						barPercentage: 0.4,
// 						categoryPercentage: 0.5
// 					}],
// 					yAxes: [{
// 						ticks: {
// 							beginAtZero: false
// 						}
// 					}]
// 				},
// 				legend: {
// 					display: false
// 				}
// 			}
// 		});
// 	}
//
// 	new Chart(document.getElementById("line-chart"), {
// 		type: 'line',
// 		data: {
// 			labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
// 			datasets: [{
// 				data: [86,114,106,106,107,111,133,221,783,2478],
// 				label: "Africa",
// 				borderColor: "#3e95cd",
// 				fill: false
// 			}, {
// 				data: [282,350,411,502,635,809,947,1402,3700,5267],
// 				label: "Asia",
// 				borderColor: "#8e5ea2",
// 				fill: false
// 			}, {
// 				data: [168,170,178,190,203,276,408,547,675,734],
// 				label: "Europe",
// 				borderColor: "#3cba9f",
// 				fill: false
// 			}, {
// 				data: [40,20,10,16,24,38,74,167,508,784],
// 				label: "Latin America",
// 				borderColor: "#e8c3b9",
// 				fill: false
// 			}, {
// 				data: [6,3,2,2,7,26,82,172,312,433],
// 				label: "North America",
// 				borderColor: "#c45850",
// 				fill: false
// 			}
// 			]
// 		},
// 		options: {
// 			title: {
// 				display: true,
// 				text: 'World population per region (in millions)'
// 			}
// 		}
// 	});
//
//
// // Bar chart
// 	new Chart(document.getElementById("bar-chart"), {
// 		type: 'bar',
// 		data: {
// 			labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
// 			datasets: [
// 				{
// 					label: "Population (millions)",
// 					backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
// 					data: [2478, 5267, 734, 784, 433]
// 				}
// 			]
// 		},
// 		options: {
// 			legend: {display: false},
// 			title: {
// 				display: true,
// 				text: 'Predicted world population (millions) in 2050'
// 			}
// 		}
// 	});
//
// 	new Chart(document.getElementById("bar-chart-grouped"), {
// 		type: 'bar',
// 		data: {
// 			labels: ["1900", "1950", "1999", "2050"],
// 			datasets: [
// 				{
// 					label: "Africa",
// 					backgroundColor: "#3e95cd",
// 					data: [133,221,783,2478]
// 				}, {
// 					label: "Europe",
// 					backgroundColor: "#8e5ea2",
// 					data: [408,547,675,734]
// 				}
// 			]
// 		},
// 		options: {
// 			title: {
// 				display: true,
// 				text: 'Population growth (millions)'
// 			}
// 		}
// 	});
//
//
// } )
//
