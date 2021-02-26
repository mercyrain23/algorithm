select W1.id 
from Weather W1, Weather W2
where W1.recordDate = Date_sub(W2.recordDate, interval -1 day) and W1.Temperature > W2.Temperature