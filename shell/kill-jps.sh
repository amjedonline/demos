for pid in `sudo jps | awk '{print $1}' `;do  echo "killing "$pid; sudo kill -9 $pid; done

