import React, {useEffect, useState} from "react";

const Timer = ({initialMinutes = 5, initialSeconds = 0}) => {
    const [minutes, setMinutes] = useState(initialMinutes);
    const [seconds, setSeconds] = useState(initialSeconds);

    useEffect(() => {
        const updateTime = () => {
            if (minutes === 0 && seconds === 0) {
                setMinutes(initialMinutes); // Reset to initial values when time is up
                setSeconds(0);
            } else if (seconds === 0) {
                setMinutes(minutes - 1);
                setSeconds(59);
            } else {
                setSeconds(seconds - 1);
            }
        };

        const timeoutId = setTimeout(updateTime, 1000);

        return () => clearTimeout(timeoutId);
    }, [minutes, seconds, initialMinutes]);

    return (
        <div>
            Time Remaining: {minutes}:{seconds < 10 ? `0${seconds}` : seconds}
        </div>
    );
};

export default Timer;
