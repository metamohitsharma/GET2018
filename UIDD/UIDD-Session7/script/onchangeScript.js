//Changes Fields according to States
function changeState(event) {
	var state = document.getElementById('state').value;
	var form = document.getElementById('form_container');
	var hosting = document.getElementById("hosting_container");
	var zipcode = document.getElementById("zipcode_container");
	var description = document.getElementById("project_container");
	var domain = document.getElementById("domain_container");

	//Removing Elements if Already Exists
	if (form.contains(hosting)) {
		form.removeChild(hosting);
	}
	if (form.contains(zipcode)) {
		form.removeChild(zipcode);
	}
	if (form.contains(description)) {
		form.removeChild(description);
	}
	if (form.contains(domain)) {
		form.removeChild(domain);
	}

	//Appending Elements according to State
	switch (state) {
		case "Rajasthan":
			domainAppend();
			projectDescriptionAppend();
			document.getElementById('website').addEventListener('focusout', checkDomain);
			document.getElementById('description').addEventListener('focusout', checkDescription);
			break;
		case "Haryana":
			zipcodeAppend();
			hostingAppend();
			document.getElementById('zipcode').addEventListener('focusout', checkZipcode);
			break;
		case "Maharashtra":
			zipcodeAppend();
			projectDescriptionAppend();
			document.getElementById('zipcode').addEventListener('focusout', checkZipcode);
			document.getElementById('description').addEventListener('focusout', checkDescription);
			break;
	}
}

//Appending Domain
function domainAppend() {
	var form = document.getElementById('form_container');
	var submitButton = document.getElementById('submit_container');

	//Creating Div for Appending Domain
	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'domain_container');

	//Creating Div for Appending Label
	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	//Creating Label
	var label = document.createElement('label');
	label.innerHTML = "Website or domain name";
	inner_div_label.appendChild(label);

	//Creating Div for Appending Icon
	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	//Creating Icon
	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-globe-americas";
	inner_div_icon.append(fontAwesome);

	//Creating Div for Appending Content
	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	//Creating Input
	var website = document.createElement('input');
	website.setAttribute('type', 'text');
	website.setAttribute('placeholder', 'Website or domain name');
	website.setAttribute('id', 'website');
	website.setAttribute('name', 'website');
	inner_div_content.appendChild(website);

	//Inserting Created Domain Element Before Submit Button
	form.insertBefore(div, submitButton);
}

//Appending Project
function projectDescriptionAppend() {
	var form = document.getElementById('form_container');
	var submitButton = document.getElementById('submit_container');

	//Creating Div for Appending Project
	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'project_container');

	//Creating Div for Appending Label
	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	//Creating Label
	var label = document.createElement('label');
	label.innerHTML = "Project Description";
	inner_div_label.appendChild(label);

	//Creating Div for Appending Icon
	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	//Creating Icon
	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-pen";
	inner_div_icon.append(fontAwesome);

	//Creating Div for Appending Content
	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	//Creating Input
	var textarea = document.createElement('textarea');
	textarea.setAttribute('placeholder', 'Project Description');
	textarea.setAttribute('id', 'description');
	textarea.setAttribute('name', 'description');
	inner_div_content.appendChild(textarea);

	//Inserting Created Project Element Before Submit Button
	form.insertBefore(div, submitButton);
}

//Appending Project
function zipcodeAppend() {
	var form = document.getElementById('form_container');
	var submitButton = document.getElementById('submit_container');

	//Creating Div for Appending ZipCode
	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'zipcode_container');

	//Creating Div for Appending Label
	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	//Creating Label
	var label = document.createElement('label');
	label.innerHTML = "Zip Code";
	inner_div_label.appendChild(label);

	//Creating Div for Appending Icon
	var inner_div_icon = document.createElement('div');
	inner_div_icon.setAttribute('class', 'icon');
	div.appendChild(inner_div_icon);

	//Creating Icon
	var fontAwesome = document.createElement('i');
	fontAwesome.className = "fas fa-home";
	inner_div_icon.append(fontAwesome);

	//Creating Div for Appending Content
	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	//Creating Input
	var zipcode = document.createElement('input');
	zipcode.setAttribute('type', 'text');
	zipcode.setAttribute('placeholder', 'Zip Code');
	zipcode.setAttribute('id', 'zipcode');
	zipcode.setAttribute('name', 'zipcode');
	inner_div_content.appendChild(zipcode);

	//Inserting Created ZipCode Element Before Submit Button
	form.insertBefore(div, submitButton);
}

//Appending Hosting
function hostingAppend() {
	var form = document.getElementById('form_container');
	var submitButton = document.getElementById('submit_container');

	//Creating Div for Appending Hosting
	var div = document.createElement('div');
	div.setAttribute('class', 'row');
	div.setAttribute('id', 'hosting_container');

	//Creating Div for Appending Label
	var inner_div_label = document.createElement('div');
	inner_div_label.setAttribute('class', 'label');
	div.appendChild(inner_div_label);

	//Creating Label
	var label = document.createElement('label');
	label.innerHTML = "Do you have Hosting?";
	inner_div_label.appendChild(label);

	//Creating Div for Appending Content
	var inner_div_content = document.createElement('div');
	inner_div_content.setAttribute('class', 'content');
	div.appendChild(inner_div_content);

	//Creating Radio Button
	var yes = document.createTextNode("Yes");
	var no = document.createTextNode("No");
	var inputyes = document.createElement("input");
	inputyes.type = "radio";
	inputyes.name = "hosting";
	inputyes.id = "yes";
	inputyes.value = "yes";
	var inputno = document.createElement("input");
	inputno.type = "radio";
	inputno.name = "hosting";
	inputno.id = "no";
	inputno.value = "no";
	inner_div_content.appendChild(inputyes);
	inner_div_content.appendChild(yes);
	inner_div_content.appendChild(inputno);
	inner_div_content.appendChild(no);

	//Inserting Created Hosting Element Before Submit Button
	form.insertBefore(div, submitButton);
}