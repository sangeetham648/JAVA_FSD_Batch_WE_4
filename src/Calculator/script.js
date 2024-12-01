document.addEventListener("DOMContentLoaded", () => {
    const container = document.getElementById('container');
    if (container) {
        {
            let screen = document.querySelector('.screen');
            let buttons = document.querySelectorAll('.btn');
            let clearAll = document.querySelector('.btn-clearAll');
            let clear = document.querySelector('.btn-clear');
            let equal = document.querySelector('.btn-equal');

            buttons.forEach(function(button) {
                button.addEventListener('click', function(e) {
                    let value = e.target.dataset.num;
                    if (value !== undefined) {
                        screen.value += value;
                    }
                });
            });

            equal.addEventListener('click', function(e) {
                if (screen.value === '') {
                    screen.value = "Please enter";
                } else {
                    try {
                        let answer = eval(screen.value.replace(/x/g, "*")); // Replace 'x' with '*'
                        screen.value = answer;
                    } catch (error) {
                        screen.value = "Error";
                    }
                }
            });

            clearAll.addEventListener('click', function(e) {
                screen.value = "";
            });

            clear.addEventListener('click', function(e) {
                screen.value = screen.value.slice(0, -1);
            });

            // Keyboard Event Listener
            document.addEventListener('keydown', function(e) {
                const allowedKeys = "0123456789+-*/.";
                const key = e.key;

                if (allowedKeys.includes(key)) {
                    // If key is a valid input, append it to the screen
                    screen.value += key;
                } else if (key === "Enter") {
                    // Evaluate expression on Enter
                    equal.click();
                } else if (key === "Backspace") {
                    // Clear last character on Backspace
                    clear.click();
                } else if (key === "Escape") {
                    // Clear all on Escape
                    clearAll.click();
                } else {
                    // Show error for invalid input
                    screen.value = "Invalid Key!";
                    setTimeout(() => {
                        screen.value = "";
                    }, 1000);
                }
            });
        }
    } else {
        console.error("Container element not found!");
    }
});