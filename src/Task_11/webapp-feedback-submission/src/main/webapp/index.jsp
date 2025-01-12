<html>
<head>
    <title>Feedback Form</title>
    <style>
        body {
            margin: 0;
            background-color: blueviolet;
        }

        h1 {
            font-size: 40px;
            text-align: center;
            color: #ffff;
            margin: 5%;
        }

        form {
            text-align: center;
            color: khaki;
            font-size: xx-large;
            margin: 5% auto;
            max-width: 1000px;
        }

        button {
            padding: 16px;
            border: 2px solid #000000;
            border-radius: 10px;
            background: darkorange;
            color: floralwhite;
            font-size: 16px;
        }

        label {
            width: 230px;
            text-align: left;
        }

        div {
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
            align-items: center;
            margin-bottom: 24px;
        }

        input,
        textarea {
            padding: 10px;
            width: 50%;
            font-size: smaller;
        }
    </style>
</head>
<body>
<h1>Feedback Form</h1>
<form action="submitFeedback" method="post">
    <div>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required /><br/><br/>
    </div>
    <div>
    <label for="book">Book Name:</label>
    <input type="text" id="book" name="book" required /><br/><br/>
    </div>
    <div>
    <label for="feedback">Feedback:</label><br/>
    <textarea id="feedback" name="feedback" rows="4" cols="50" required></textarea><br/><br/>
    </div>
    <button type="submit">Submit Feedback</button>
</form>
</body>
</html>
