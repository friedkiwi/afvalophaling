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

        .back-black {
            background-color: black;
            border: 1px solid black;
            color: white;
            padding: 3px 3px 3px 3px;
        }

        .back-blue {
            background-color: blue;
            border: 1px solid black;
            color: white;
            padding: 3px 3px 3px 3px;
        }

        .back-orange {
            background-color: orange;
            border: 1px solid black;
            padding: 3px 3px 3px 3px;
        }

        .qr {
            position: absolute ;
            top: 0px;
            right: 0px;
            height: 200px;
            width: 200px;
            display: none;
        }
        @media print {
            .qr {
                display: block;
            }

            .srclink {
                display: none;
            }
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
            <li>PMD</li>
        </ul>
        Deze containers worden opgehaald volgens het volgende schema:
        <ul>
            <li>Restafval: elke dinsdag en vrijdag</li>
            <li>Glas: vrijdag, tweewekelijks</li>
            <li>Papier: dinsdag, tweewekelijks</li>
            <li>PMD: dinsdag, tweewekelijks</li>
        </ul>
    </p>
    <p>
        Wanneer de containers vol zijn (eg. papier of PMD), gelieve dit ook zelf bij te houden en buiten te zetten volgens de Ivago kalender.
    </p>
<h2>Eerstvolgende ophaalbeurten:</h2>
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
                                <span class="back-black">Zwart</span>
                            </s:if>
                            <s:if test='#ophaling.toString() == "Papier"'>
                                <span class="back-blue">Blauw</span>
                            </s:if>
                            <s:if test='#ophaling.toString() == "PMD"'>
                                <span class="back-black">Zwart</span>
                            </s:if>
                            <s:if test='#ophaling.toString() == "Glas"'>
                                <span class="back-orange">Oranje</span>
                            </s:if>
                        </p>
                    </s:iterator>

                </td>
                <td><s:date name="buitenzetDatum" format="dd/MM/yyyy" /> vanaf 18:00</td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div class="qr">
        <img src="web_page_qr.png" alt="web page URL QR code" />
    </div>
    <p class="srclink">
        De broncode voor deze pagina staat op <a href="https://github.com/friedkiwi/afvalophaling">Github</a>.
    </p>
</div>
</body>
</html>