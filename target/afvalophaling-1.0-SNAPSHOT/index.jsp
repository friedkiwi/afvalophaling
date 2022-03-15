<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Afvalophaling Res. Kalandeberg</title>
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <sb:head/>

    <style type="text/css">
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</head>
<body>

<div class="container" role="main">

    <h1>Afvalophaalkalender containers</h1>
    <p>
        In dit gebouw worden de volgende soorten afval opgehaald met gedeelde containers: <br/>
        <ul>
            <li>Restafval</li>
            <li>Papier</li>
            <li>Glas</li>
        </ul>
        PMD word niet op deze manier opgehaald, u dient dit dus zelf bij te houden in uw appartement en buiten te zetten volgens de Ivago kalender.
        Wanneer de containers vol zijn (eg. papier), gelieve dit ook zelf bij te houden en buiten te zetten volgens de Ivago kalender.
    </p>
    <!--
    <p>Klik <a href="#">hier</a> om deze gegevens toe te voegen aan je agenda.</p>
    -->

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Datum</th>
            <th scope="col">Containers</th>
            <th scope="col">Buiten zetten om</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="ophaaldagen">
            <tr>
                <th scope="row"><s:date name="datum" format="dd/MM/yyyy" /></th>
                <td>

                    <s:iterator value="ophalingen" var="ophaling">
                        <p>
                            <s:property value="ophaling" />
                            <s:if test='#ophaling.toString() == "Restafval"'>
                                <button type="button" class="btn btn-dark btn-sm">Zwarte container</button>
                            </s:if>
                            <s:if test='#ophaling.toString() == "Papier"'>
                                <button type="button" class="btn btn-primary btn-sm">Blauwe container</button>
                            </s:if>
                            <s:if test='#ophaling.toString() == "Glas"'>
                                <button type="button" class="btn btn-warning btn-sm">Oranje container</button>
                            </s:if>
                        </p>
                    </s:iterator>

                </td>
                <td><s:date name="buitenzetDatum" format="dd/MM/yyyy" /> om 18:00</td>
            </tr>
        </s:iterator>
        <!--
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
        </tr>
        -->
        </tbody>
    </table>
    <p>
        Up-to-date versie: <br />
        <img src="web_page_qr.png" alt="web page URL QR code" />
    </p>
</div>
</body>
</html>