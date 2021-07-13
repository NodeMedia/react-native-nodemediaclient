declare module 'react-native-nodemediaclient' {
  import type * as React from 'react';
  import { ViewProps } from 'react-native';

  export interface NodeCameraViewProps extends ViewProps {
    ref?: any;
    /**
     * RTMP endpoint
     */
    outputUrl: string;
    /** Stream Camera configs */
    camera?: CameraConfig;
    /** Stream audio configs */
    audio?: AudioConfig;
    /** Stream Video configs */
    video?: VideoConfig;
    /** Enable preview of camera */
    autopreview?: boolean;
    /** Enable denoise for better quality. It increase CPU and memory usage */
    denoise?: boolean;
    /** Enable dynamic bitrate for auto increase or decreate depending of connection */
    dynamicRateEnable?: boolean;
    /** Level of smoothing skin 0 is disabled
     * @max 5
     */
    smoothSkinLevel?: number;
    cryptoKey?: string;
    /** Called when streaming status has changed */
    onStatus?(code?: OutputStreamStatus, status?: string): any;
  }

  export interface NodeCameraViewType {
    /** Stop streaming */
    stop(): any;
    /** Start streaming */
    start(): any;
    /** Switch front or back camera */
    switchCamera(): any;
    /** Enable or disable flash */
    flashEnable(enable?: boolean): any;
    /** Start camera preview */
    startPreview(): any;
    /** Stop camera preview */
    stopPreview(): any;
  }

  export interface VideoConfig {
    /**
     * Video sizes and Aspect Ratio
     * @requires VideoAspectRatios
     */
    preset?: AR16X9 | AR4X3 | AR1X1;

    /** This define how much bytes will be send for the stream video
     * higher values have better quality but requires a better internet connection
     */
    bitrate?: number;

    /** Video quality profiles */
    profile?: VideoProfiles;

    /** frames per second */
    fps?: number;

    /** Define if front camera should mirror image for preview */
    videoFrontMirror?: boolean;
  }

  export interface AudioConfig {
    /** This define how much bytes will be send for the stream video
     * higher values have better quality but requires a better internet connection
     */
    bitrate?: number;

    /** Audio Quality profiles */
    profile?: AudioProfiles;

    /** @range 32000 - 48000 */
    samplerate?: number;
  }

  export interface CameraConfig {
    /** define front or back camera used to stream */
    cameraId?: CameraId;

    /** Define if front camera should mirror image for preview */
    cameraFrontMirror?: boolean;
  }

  /** Cameras */
  export enum CameraId {
    BackCamera = 0,
    FrontCamera = 1,
  }

  export enum OutputStreamStatus {
    /** Connecting stream */
    Connecting = 2000,

    /** Start Publishing */
    Start = 2001,

    /** Connection Failed */
    Failed = 2002,

    /** Connection Closed */
    Closed = 2004,

    /** Publish network congestion */
    Congestion = 2100,
  }
  /** Video sizes for 16x9 aspect ratio
   * @example 1080p is 1920x1080
   */
  export enum AR16X9 {
    '270p' = 0,
    '360p' = 1,
    '480p' = 2,
    '540p' = 3,
    '720p' = 4,
    '1080p' = 5,
  }
  /** Video sizes for 4x3 aspect ratio
   * @example 1080p is 1440x1080
   */
  export enum AR4X3 {
    '270p' = 10,
    '360p' = 11,
    '480p' = 12,
    '540p' = 13,
    '720p' = 14,
    '1080p' = 15,
  }
  /** Video sizes for 1x1 aspect ratio
   * @example 1080p is 1080x1080
   */
  export enum AR1X1 {
    '270p' = 20,
    '360p' = 21,
    '480p' = 22,
    '540p' = 23,
    '720p' = 24,
    '1080p' = 25,
  }
  /** Aspect ratios */
  export type VideoAspectRatios = {
    '16x9': AR16X9;
    '4x3': AR4X3;
    '1x1': AR1X1;
  };

  /** Audio Quality profiles */
  export enum AudioProfiles {
    /** Low Complexity Advanced Audio Coding */
    LCAAC = 0,
    /** High-Efficiency Advanced Audio Coding (better) */
    HEAAC = 1,
  }

  export enum VideoProfiles {
    /** low quality */
    BASELINE = 0,
    /** normal quality */
    MAIN = 1,
    /** high quality */
    HIGH = 2,
  }

  export enum InputStreamStatus {
    Connecting = 1000,
    Connected = 1001,
    Reconnection = 1003,
    Buffering = 1101,
    BufferFull = 1102,
    Resolution = 1104,
    None = 0,
  }

  export interface NodePlayerViewProps extends ViewProps {
    ref: any;
    inputUrl: string;
    bufferTime?: number;
    maxBufferTime?: number;
    autoplay?: boolean;
    audioEnable?: boolean;
    scaleMode?: 'ScaleToFill' | 'ScaleAspectFit' | 'ScaleAspectFill';
    renderType?: 'SURFACEVIEW' | 'TEXTUREVIEW';
    cryptoKey?: string;
    onStatus?(code?: InputStreamStatus, status?: string): any;
  }

  export interface NodePlayerViewType {
    /** Pause video */
    pause(): any;
    /** Stop video */
    stop(): any;
    /** Start video */
    start(): any;
  }

  export const NodePlayerView: React.ForwardRefRenderFunction<NodePlayerViewType, NodePlayerViewProps>;

  export const NodeCameraView: React.ForwardRefRenderFunction<NodeCameraViewType, NodeCameraViewProps>;
}
