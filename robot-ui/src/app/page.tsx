import styles from './page.module.css';
import RobotPage from '@/app/RobotPage';

export default function Home() {
  return (
    <main className={styles.main}>
      <RobotPage></RobotPage>
    </main>
  );
}
